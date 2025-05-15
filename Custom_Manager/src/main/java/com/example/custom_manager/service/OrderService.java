package com.example.custom_manager.service;



import com.example.custom_manager.model.Delivery;
import com.example.custom_manager.model.Order;
import com.example.custom_manager.model.OrderDetail;
import com.example.custom_manager.model.Payment;
import com.example.custom_manager.repository.DeliveryRepository;
import com.example.custom_manager.repository.OrderDetailRepository;
import com.example.custom_manager.repository.OrderRepository;
import com.example.custom_manager.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Transactional
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;


    public Order placeOrder(Order orderData){

        //Save order
        Date orderDate = new Date();
        orderData.setOrder_date(orderDate);
        orderData.setOrder_status("OK");
        orderRepository.save(orderData);



        //save orderdetail

        for(OrderDetail orderDetail : orderData.getOrderDetails()){
            orderDetail.setOrder_id(orderData.getOrder_id());
            orderDetailRepository.save(orderDetail);
        }

        //save payment
        Payment payment = new Payment();
        payment.setOrder_id(orderData.getOrder_id());
        payment.setPayment_date(orderData.getOrder_date());
        payment.setPayment_method(orderData.getPayment_method());
        payment.setStatus("OK");
        paymentRepository.save(payment);

        //save delivery
        Delivery delivery = new Delivery();
        delivery.setDelivery_partner_id(orderData.getDeliverypartner_id());
        delivery.setOrder_id(orderData.getOrder_id());
        delivery.setShipping_address(orderData.getShipping_address());

        deliveryRepository.save(delivery);

        return  orderData;
    }


}
