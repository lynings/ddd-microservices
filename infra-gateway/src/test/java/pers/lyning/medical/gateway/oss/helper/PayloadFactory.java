package pers.lyning.medical.gateway.oss.helper;

import org.assertj.core.util.Lists;
import pers.lyning.medical.gateway.client.patient.Patient;
import pers.lyning.medical.gateway.client.patient.Permission;
import pers.lyning.medical.gateway.oss.Payload;

import java.util.ArrayList;

/**
 * @author lyning
 */
public class PayloadFactory {

    public static Payload create() {
        final ArrayList<Permission> permissions = Lists.newArrayList(new Permission("/patients", "link.get.patient", "get"));
        final Patient patient = new Patient("admin", "admin", permissions);
        return new Payload(patient);
    }
}
