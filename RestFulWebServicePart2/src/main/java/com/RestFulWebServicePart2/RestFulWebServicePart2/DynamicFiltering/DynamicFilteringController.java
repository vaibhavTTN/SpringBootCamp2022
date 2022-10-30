package com.RestFulWebServicePart2.RestFulWebServicePart2.DynamicFiltering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicFilteringController {

    @RequestMapping("/dynamicFiltering")
    public MappingJacksonValue dynamicFiltering(){

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","salary");

        FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicFilter",filter);

        DynamicUser dynamicUser = new DynamicUser(1,40000,"vaibhav kamal","password");

        MappingJacksonValue mapping = new MappingJacksonValue(dynamicUser);

        mapping.setFilters(filters);

        return mapping;
    }
}
