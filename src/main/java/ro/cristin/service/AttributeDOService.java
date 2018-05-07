package ro.cristin.service;

import ro.cristin.model.AttributeDO;

import java.util.List;

public interface AttributeDOService {

    List<AttributeDO> getAllAttributes();
    void addAttribute(AttributeDO attribute);
    void deleteAttribute(AttributeDO attribute);
}
