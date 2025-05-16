package com.example.custom_manager.service;



import com.example.custom_manager.model.*;
import com.example.custom_manager.repository.DeliveryRepository;
import com.example.custom_manager.repository.OrderDetailRepository;
import com.example.custom_manager.repository.OrderRepository;
import com.example.custom_manager.repository.PaymentRepository;
import com.example.custom_manager.repository.DeliveryPartnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

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

    @Autowired
    private DeliveryPartnerRepository deliveryPartnerRepository;


    public Order placeOrder(Order orderData){


        //save order
        orderData.setOrder_date(new Date());
        orderData.setOrder_status("SUCCESS");
        Order savedOrder = orderRepository.save(orderData);

        //save order detail
        for (OrderDetail detail : orderData.getOrderDetails()) {
            detail.setOrder(savedOrder);
            orderDetailRepository.save(detail);
        }


        //save payment
        Payment payment = new Payment();
        payment.setOrder(savedOrder);
        payment.setPayment_date(savedOrder.getOrder_date());
        payment.setPayment_method(savedOrder.getPayment_method());
        payment.setStatus("PENDING");
        paymentRepository.save(payment);

        //save delivery
        Delivery delivery = new Delivery();
        delivery.setOrder(savedOrder);
        delivery.setShipping_address(savedOrder.getShipping_address());
        Optional<DeliveryPartner> deliveryPartner = deliveryPartnerRepository.findById(savedOrder.getDeliverypartner_id());
        if (deliveryPartner.isPresent()) {
            delivery.setDeliveryPartner(deliveryPartner.get());
            deliveryRepository.save(delivery);
        }

        return savedOrder;
    }



}
