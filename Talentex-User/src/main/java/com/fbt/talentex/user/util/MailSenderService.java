
package com.fbt.talentex.user.util;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;



@Service
public class MailSenderService { 

	@Autowired
	private JavaMailSender mailSender;  

	@Autowired
	VelocityEngine velocityEngine; 



	public void sendForgetPassword(final String toEmailAddress, final Integer UserId,final String username)
	{
		final String fromEmailAddress = "info@talentex.in";
		final String subject = "TalentEx- Forget Password";
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
				message.setTo(toEmailAddress);
				message.setFrom(new InternetAddress(fromEmailAddress));
				message.setSubject(subject);
				Map<String, String> model = new HashMap<String, String>();
				model.put("toaddress", toEmailAddress);
				model.put("username",username);
				String body = VelocityEngineUtils.
						mergeTemplateIntoString(
								velocityEngine, "./templates/mail.vm", "UTF-8", model);
				message.setText(body, true);

			}
		}; 
		this.mailSender.send(preparator);
	}
}

