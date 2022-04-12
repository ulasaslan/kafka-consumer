package ulas.kafkaconsumer.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.kafkaconsumer.entity.FoodOrder;
import ulas.kafkaconsumer.repository.FoodOrderRepository;
import ulas.kafkaconsumer.service.Dto.FoodOrderDto;

@Service
@RequiredArgsConstructor
public class FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;
    private final ModelMapper modelMapper;


    public void persistFoodOrder(FoodOrderDto foodOrderDto) {
        FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);
        FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);
    }

}
