package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database)
    {
        commands = new HashMap<>();
        commands.put("orderHandler", new CommandOrderHandler("orderHandler","employee"));
        commands.put("orderHandlercustomer", new CommandOrderHandlerCustomer("orderHandlercustomer","customer"));
        commands.put("updatePrice", new CommandOrderUpdater("orderHandler","employee"));
        commands.put("showOrders", new OrderListCommand("showallorders","employee"));
        commands.put("newrequestpage", new CommandNewRequest("newrequestpage", "customer"));
        commands.put("viewrequestpage", new CommandViewRequest("viewrequestpage", "customer"));
        commands.put("editorder", new OrderListCommand("editorderpage","employee"));
        commands.put("showsingleorder", new OrderByIdCommand("showsingleorderpage","employee"));
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("showcarportrequestpage", new CommandShowCarportRequest ("showcarportrequestpage", "employee"));
        commands.put("receiptpage", new CarportHandlerCommand ("receiptpage"));
        commands.put("showsvg", new ShowSVGCommand ("showsvgpage", "employee"));
        commands.put("showsvgcustomer", new ShowSVGCommandcustomer ("showsvgpage", "customer"));

    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;

}
