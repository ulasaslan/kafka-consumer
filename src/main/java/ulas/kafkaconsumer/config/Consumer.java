package ulas.kafkaconsumer.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ulas.kafkaconsumer.service.Dto.FoodOrderDto;
import ulas.kafkaconsumer.service.FoodOrderService;

@RequiredArgsConstructor
@Component
public class Consumer {
    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final FoodOrderService foodOrderService;



    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        FoodOrderDto foodOrderDto = objectMapper.readValue(message, FoodOrderDto.class);
        foodOrderService.persistFoodOrder(foodOrderDto);
    }
}
