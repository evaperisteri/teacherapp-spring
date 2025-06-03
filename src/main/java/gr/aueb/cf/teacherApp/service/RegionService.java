package gr.aueb.cf.teacherApp.service;

import gr.aueb.cf.teacherApp.model.static_data.Region;
import gr.aueb.cf.teacherApp.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RegionService implements IRegionService{

    private final RegionRepository regionRepository;
    //εναλλακτικά του @RequiredArgsConstructor (από το lombok) μπαίνει ο παρακάτω constructor με  @Autowired
//    @Autowired
//    public RegionService(RegionRepository regionRepository) {
//        this.regionRepository = regionRepository;
//    }

    @Override
    public List<Region> findAllRegions() {
        return regionRepository.findAll();
    }
}
