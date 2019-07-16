package pers.lyning.medical.gateway.client.patient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lyning
 */
@FeignClient(name = "patient-service")
public interface PatientClient {

    /**
     * 根据 username 获取患者信息
     *
     * @param username 患者用户名
     * @return 患者信息
     */
    @GetMapping("/patients")
    Patient obtainByUsername(@RequestParam("username") String username);
}
