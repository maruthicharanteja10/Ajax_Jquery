package com.springboot.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/location")
public class DropdownController {

	private final Map<String, List<String>> stateMap = new HashMap<>();
    private final Map<String, List<String>> cityMap = new HashMap<>();

    public DropdownController() {
        // Hardcoded State Data
        stateMap.put("USA", List.of("California", "Texas", "New York"));
        stateMap.put("India", List.of("Maharashtra", "Karnataka", "Delhi"));

        // Hardcoded City Data
        cityMap.put("California", List.of("Los Angeles", "San Francisco", "San Diego"));
        cityMap.put("Texas", List.of("Houston", "Dallas", "Austin"));
        cityMap.put("New York", List.of("New York City", "Buffalo", "Albany"));
        cityMap.put("Maharashtra", List.of("Mumbai", "Pune", "Nagpur"));
        cityMap.put("Karnataka", List.of("Bangalore", "Mysore", "Mangalore"));
        cityMap.put("Delhi", List.of("New Delhi", "Dwarka", "Rohini"));
    }

    @GetMapping
    public String showDropdownPage() {
        return "index";  // Loads HTML page
    }

    @GetMapping("/loadStates")
    @ResponseBody
    public String loadStates(@RequestParam("country") String country) {
        List<String> states = stateMap.getOrDefault(country, List.of());
        return states.stream()
                .map(state -> "<option value='" + state + "'>" + state + "</option>")
                .collect(Collectors.joining());
    }

    @GetMapping("/loadCities")
    @ResponseBody
    public String loadCities(@RequestParam("state") String state) {
        List<String> cities = cityMap.getOrDefault(state, List.of());
        return cities.stream()
                .map(city -> "<option value='" + city + "'>" + city + "</option>")
                .collect(Collectors.joining());
    }
}
