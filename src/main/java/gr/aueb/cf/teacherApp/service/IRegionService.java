package gr.aueb.cf.teacherApp.service;

import gr.aueb.cf.teacherApp.model.static_data.Region;

import java.util.List;

public interface IRegionService {
    List<Region> findAllRegions();
}
