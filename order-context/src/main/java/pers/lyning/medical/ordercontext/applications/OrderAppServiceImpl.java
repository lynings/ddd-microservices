package pers.lyning.medical.ordercontext.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lyning.medical.ordercontext.gateways.acl.user.PatientClient;
import pers.lyning.medical.ordercontext.gateways.acl.user.User;
import pers.lyning.medical.ordercontext.gateways.ohs.data.OrderCommand;
import pers.lyning.medical.ordercontext.interfaces.OrderAppService;

/**
 * @author lyning
 */
@Service
public class OrderAppServiceImpl implements OrderAppService {

    private final PatientClient patientClient;

    @Autowired
    public OrderAppServiceImpl(final PatientClient patientClient) {
        this.patientClient = patientClient;
    }

    @Override
    public Long placeOrder(final OrderCommand orderCommand) {
        final User user = this.patientClient.obtainById(orderCommand.getPatientId());
        return user.getId();
    }
}
