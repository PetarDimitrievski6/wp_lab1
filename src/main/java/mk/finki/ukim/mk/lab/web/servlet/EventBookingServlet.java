package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "event-booking-servlet", urlPatterns = "/eventBooking")
public class EventBookingServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final EventBookingService eventBookingService;

    public EventBookingServlet(SpringTemplateEngine springTemplateEngine, EventBookingService eventBookingService) {
        this.springTemplateEngine = springTemplateEngine;
        this.eventBookingService = eventBookingService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String attendeeName = req.getHeader("User-Agent");
        String ipAddress = req.getRemoteAddr();
        String event = req.getParameter("eventChoice");
        String nOfTickets = req.getParameter("numTickets");
        eventBookingService.placeBooking(event,
                attendeeName,
                ipAddress,
                Integer.parseInt(nOfTickets));
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("attendeeName", attendeeName);
        context.setVariable("ipAddress", ipAddress);
        context.setVariable("event", event);
        context.setVariable("nOfTickets", nOfTickets);

        this.springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());
    }
}
