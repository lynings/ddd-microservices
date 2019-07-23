package pers.lyning.medical.ordercontext.application;

import org.springframework.beans.factory.annotation.Autowired;
import pers.lyning.medical.corestandard.ddd.annotation.application.ApplicationService;
import pers.lyning.medical.ordercontext.gateways.acl.patient.Patient;
import pers.lyning.medical.ordercontext.gateways.acl.patient.PatientClient;
import pers.lyning.medical.ordercontext.gateways.ohs.data.PlaceOrderCommand;
import pers.lyning.medical.ordercontext.interfaces.OrderAppService;

/**
 * @author lyning
 */
@ApplicationService
public class OrderAppServiceImpl implements OrderAppService {

    private final PatientClient patientClient;

    @Autowired
    public OrderAppServiceImpl(final PatientClient patientClient) {
        this.patientClient = patientClient;
    }

    @Override
    public void complete(Long orderId) {

    }

    @Override
    public Long placeOrder(final PlaceOrderCommand placeOrderCommand) {
        final Patient patient = this.patientClient.obtainById(placeOrderCommand.getPatientId());
        return patient.getId();
    }
}
