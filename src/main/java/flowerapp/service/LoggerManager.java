package flowerapp.service;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class LoggerManager {

    private static final Logger logger = Logger.getLogger(LoggerManager.class.getName());
    private static final String LOG_FILE = "flowerapp.log";

    private static final String ADMIN_EMAIL = "email@gmail.com";
    private static final String ADMIN_PASSWORD = "password";
    private static final String TO_EMAIL = "email@gmail.com";

    static {
        try {
            FileHandler fileHandler = new FileHandler(LOG_FILE, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);

            logger.info("Логування ініціалізовано. Логи зберігаються у файлі " + LOG_FILE);
        } catch (IOException e) {
            System.err.println("Помилка при створенні лог-файлу: " + e.getMessage());
        }
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarning(String message) {
        logger.warning(message);
    }

    public static void logError(String message, Exception e) {
        logger.severe(message + " — " + e.getMessage());
        sendCriticalEmail(message, e);
    }

    private static void sendCriticalEmail(String message, Exception e) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(ADMIN_EMAIL, ADMIN_PASSWORD);
                }
            });

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(ADMIN_EMAIL));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO_EMAIL));
            msg.setSubject("FlowerApp – Критична помилка");
            msg.setText("Виявлено критичну помилку:\n\n" +
                    message + "\n\n" +
                    "Деталі:\n" + e.getMessage());

            Transport.send(msg);
            logger.info("Критична помилка надіслана на e-mail " + TO_EMAIL);
        } catch (Exception ex) {
            logger.warning("Не вдалося надіслати e-mail: " + ex.getMessage());
        }
    }
}
