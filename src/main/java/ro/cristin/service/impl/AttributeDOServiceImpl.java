package ro.cristin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cristin.model.AttributeDO;
import ro.cristin.repository.AttributeDORepo;
import ro.cristin.service.AttributeDOService;

import java.util.List;

@Service
public class AttributeDOServiceImpl implements AttributeDOService {

    @Autowired
    AttributeDORepo attributeRepo;

    @Override
    public List<AttributeDO> getAllAttributes() {
        return attributeRepo.findAll();
    }

    @Override
    public void addAttribute(AttributeDO attribute) {
        attributeRepo.save(attribute);
    }

    @Override
    public void deleteAttribute(AttributeDO attribute) {
        attributeRepo.delete(attribute);
    }
}
