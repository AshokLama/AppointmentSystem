package edu.miu.cs.appointmentsystem.integration.email.templates;

import edu.miu.cs.appointmentsystem.integration.models.AppointmentInfo;
import edu.miu.cs.appointmentsystem.integration.models.Email;

public class AppointmentAcceptedTemplate implements AppointmentTemplate {

    @Override
    public Email getTemplate(AppointmentInfo appointmentInfo) {
        Email email = new Email();
        email.setSubject(
                appointmentInfo.getProviderName() + ": IMPORTANT : Appointment reservation has been accepted - "
                        + appointmentInfo.getAppointmentDate() + " at " + appointmentInfo.getAppointmentTime());
        email.setBody(getBody(appointmentInfo));
        email.setTo(appointmentInfo.getClientEmail());
        return email;
    }

    private String getBody(AppointmentInfo appointmentInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append("Dear " + appointmentInfo.getClientName() + ",");
        builder.append("We would like let you know the your appointment with " + appointmentInfo.getProviderName()
                + " on " + appointmentInfo.getAppointmentDate() + " at " + appointmentInfo.getAppointmentTime());
        builder.append(" has been accepted.\r\n See you soon\r\n");
        builder.append("Regards");
        builder.append("Appointment System Team");
        return builder.toString();
    }

}
