package org.example.Driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    public String printGrid(Grid grid){
        return grid.toString();
    }
}
