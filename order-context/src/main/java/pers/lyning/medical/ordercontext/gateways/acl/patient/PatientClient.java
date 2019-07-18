package pers.lyning.medical.ordercontext.gateways.acl.patient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lyning
 */
@FeignClient(name = "patient-service")
public interface PatientClient {

    /**
     * 根据 id 获取患者信息
     *
     * @param id 患者id
     * @return 患者信息
     */
    @GetMapping("/patients/{id}")
    Patient obtainById(@PathVariable("id") Long id);
}
