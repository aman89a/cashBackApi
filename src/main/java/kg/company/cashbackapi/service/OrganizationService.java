package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.Organization;
import kg.company.cashbackapi.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization findById(Long id) throws Exception {
        return organizationRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public Organization create(Organization organization) {
        return organizationRepository.save(organization);
    }

    public String deleteById(Long id) {
        organizationRepository.deleteById(id);
        return "Organization number " + id + " has been deleted!";
    }

    public Organization putById(Long id, Organization organization) throws Exception {
        return organizationRepository.findById(id)
                .map(newOrganization -> {
                    newOrganization.setId(organization.getId());
                    newOrganization.setDescription(organization.getDescription());
                    newOrganization.setName(organization.getName());
                    newOrganization.setClients(organization.getClients());
                    newOrganization.setStatus(organization.isStatus());
                    newOrganization.setImageUrl(organization.getImageUrl());
                    newOrganization.setCreatedDate(organization.getCreatedDate());
                    newOrganization.setOrgCategory(organization.getOrgCategory());
                    return organizationRepository.save(newOrganization);
                })
                .orElseThrow(Error::new);
    }


}
