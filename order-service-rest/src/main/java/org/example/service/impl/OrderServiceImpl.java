package org.example.service.impl;

import org.example.pojo.Order;
import org.example.pojo.Product;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {


    @Autowired
    private RestTemplate restTemplate;


    //元数据法、一般不用。  ribbon 已经写好了六七种负载均衡算法。
    @Autowired
    DiscoveryClient discoveryClient;


    @Autowired
    private LoadBalancerClient loadBalancerClient; //Ribbon 负责均衡器     spring cloud netflix  网飞 模式下、无处不在。微服务间通讯方式。各组件的这个依赖必然有。


    //远程调用商品微服务
    public List<Product> selectProductListByDiscoveryClient() {
        StringBuffer sb = null;
        List<String> serviceIds = discoveryClient.getServices();

        if (CollectionUtils.isEmpty(serviceIds)) {
            return null;
        }

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("service-provider");
        //最少并发？   轮询 随机 好做

        if (CollectionUtils.isEmpty(serviceInstances)) {
            return null;
        }
        ServiceInstance si = serviceInstances.get(0);

        sb = new StringBuffer();
        sb.append("http://" + si.getHost() + ":" + si.getPort() + "/product/list");

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return responseEntity.getBody();


    }


    //远程调用商品微服务
    public List<Product> selectProductListByLoadBalancerClient() {
        StringBuffer sb = null;


        ServiceInstance si = loadBalancerClient.choose("service-provider");
        if (null == si) {
            return null;
        }


        sb = new StringBuffer();
        sb.append("http://" + si.getHost() + ":" + si.getPort() + "/product/list");

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return responseEntity.getBody();


    }





    //远程调用商品微服务
    public List<Product> selectProductListByLoadBalancerAnnotation() {

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                "http://service-provider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return responseEntity.getBody();


    }



    @Override
    public Order selectOrderByIdAndOrderNo(Integer id,String orderNo){
        return new Order(1, "order-001", "中国", 6666D, selectProductListByLoadBalancerAnnotation());
    }
}
