package com.burcuozel.restful.controller.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public StaticSomeBean retrieveSomeBean() {
		return new StaticSomeBean("value1", "value2", "value3");
	}

	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue retrieveSomeBeanDynamicFiltering() {
		SomeBean bean = new SomeBean("value1", "value2", "value3");

		MappingJacksonValue mapping = new MappingJacksonValue(bean);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		mapping.setFilters(filters);

		return mapping;
	}
}
