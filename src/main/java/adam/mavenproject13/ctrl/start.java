/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adam.mavenproject13.ctrl;

import adam.mavenproject13.bus.StartService;
import adam.mavenproject13.ents.Address;
import adam.mavenproject13.ents.Administrator;
import adam.mavenproject13.ents.Basket;
import adam.mavenproject13.ents.Books;
import adam.mavenproject13.ents.Orders;
import adam.mavenproject13.ents.PaymentMethod;
import adam.mavenproject13.ents.Person;
import adam.mavenproject13.ents.bookList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author adamt
 */
@Named(value = "start")
@SessionScoped
public class start implements Serializable {

    /**
     * Creates a new instance of start
     */
    public start() {
    }

    private String name;
    private String surname;
    private String emailAddress;
    private String password;
    
    private String loginName;
    private String loginSurname;
    private String loginEmail;
    private String loginPassword;

    private String title;
    private String author;
    private String edition;
    private String price;
    private String copy;

    private String yearOfPublication;
    private String priceRange;
    
    private Basket sb = new Basket();

    public Basket getSb() {
        return sb;
    }

    public void setSb(Basket sb) {
        this.sb = sb;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginSurname() {
        return loginSurname;
    }

    public void setLoginSurname(String loginSurname) {
        this.loginSurname = loginSurname;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @EJB
    private StartService ss;

    public void action() {
//        name = name + "!";
        ss.startStarting(name, surname, emailAddress, password);
    }

    public String loginToSystem() {
        emailAddress = emailAddress + emailAddress;
        password = password + "...";
        return "";
    }

    private List<Books> listOfBooks = new ArrayList<>();

    public List<Books> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Books> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public void findBooks() {
        List<Books> books = ss.retrieveBooks();
//        List<Books> books = ss.findBooks(title);

        for (int i = 0; i < books.size(); i++) {
            Books newBook = books.get(i);
            if (newBook.getTitle().equals(title)) {
                listOfBooks.add(newBook);
            }
        }
    }
    
    Administrator admin = new Administrator();

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }
    
    private boolean adminRender;

    public boolean isAdminRender() {
        return adminRender;
    }

    public void setAdminRender(boolean adminRender) {
        this.adminRender = adminRender;
    }
    
    public void checkAdminCredentials(){
        if(admin.getUsername().equals("admin") && admin.getPassword().equals("admin")){
            adminRender = true;
        }
    }
    public void makeOrder(){
        List<Basket> order = ss.retrieveBasket();
        List<Address> list = new ArrayList<>();
        list = ss.retrieveAddress();
        a = list.get(0);
        List<PaymentMethod> payment = ss.retrievePayment();
        pay = payment.get(0);
        for(int i = 0; i < order.size(); i++){
            Orders orderMade = new Orders();
            Basket item = order.get(i);
            orderMade.setTitle(item.getTitle());
            orderMade.setAuthor(item.getAuthor());
            orderMade.setEdition(item.getEdition());
            orderMade.setPrice(item.getPrice());
            orderMade.setCopies(item.getCopies());
            orderMade.setStatus("Ordered");
            String fullAddress = a.getLine1() + ", " + a.getLine2() + ", " + a.getLine3() + ", " + a.getLine4() + ", " + a.getLine5();
            orderMade.setAddress(fullAddress);
            String method = pay.getCardHolder() + " - " + pay.getCardNumber();
            orderMade.setPaymentMethod(method);
            ss.setOrder(orderMade, item);
        }
        shoppingBasket();
    }
    
//    @PostConstruct
    public void addBooks() {
//        ss.addAdmin();
        ss.addBooks();

    }

    private String newEmailAddress;

    public String getNewEmailAddress() {
        return newEmailAddress;
    }

    public void setNewEmailAddress(String newEmailAddress) {
        this.newEmailAddress = newEmailAddress;
    }

    public void findEmailAddress() {
        newEmailAddress = ss.findEmailAddress(name, surname);
    }

    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void findPassword() {
        newPassword = ss.findPassword(emailAddress);

    }
    
    List<Orders> orderList = new ArrayList<>();

    public List<Orders> getOrderList() {
        orderList = ss.retrieveOrders();
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }
    
    public void addToBasket(){
        ss.addBookToBasket(sb);
        order = new ArrayList<>();
        List<Basket> orderResult = ss.retrieveBasket();
        for(int i = 0; i < orderResult.size(); i++){
            Basket entry = orderResult.get(i);
            order.add(entry);
        }
//        order.add(sb);
    }
    
    public void shoppingBasket(){
        List<Basket> orderResult = ss.retrieveBasket();
        for(int i = 0; i < orderResult.size(); i++){
            Basket entry = orderResult.get(i);
            order.add(entry);
        }
    }
    
    PaymentMethod pay = new PaymentMethod();

    public PaymentMethod getPay() {
        return pay;
    }

    public void setPay(PaymentMethod pay) {
        this.pay = pay;
    }
    
    Address a = new Address();

    public Address getA() {
        return a;
    }

    public void setA(Address a) {
        this.a = a;
    }
    
    public void addPaymentMethod(){
        ss.addPaymentMethod(pay);
    }
    
    public void addDeliveryAddress(){
        ss.addDeliveryAddress(a);
    }
    
    private List<Basket> order = new ArrayList<>();

    public List<Basket> getOrder() {
        return order;
    }

    public void setOrder(List<Basket> order) {
        this.order = order;
    }
    
    private String loginStatus;

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
    
    private String accountName;

    public String getAccountName() {
        List<Person> users = ss.retrieveAccounts();
        for(int i = 0; i < users.size(); i++){
            Person p = users.get(i);
            if(p.getEmailAddress().equals(loginEmail) && p.getPassword().equals(loginPassword)){
                loginName = p.getName();
                loginSurname = p.getSurname();
                accountName = loginName + " " + loginSurname;
            }
        }
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    private boolean render = false;

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }
    
    public void checkCredentials(){
        List<Person> users = ss.retrieveAccounts();
        for(int i = 0; i < users.size(); i++){
            Person p = users.get(i);
            if(p.getEmailAddress().equals(loginEmail) && p.getPassword().equals(loginPassword)){
                loginStatus = "Email Address and Password match existing account";
                render = true;
                break;
            } else if(p.getEmailAddress().equals(loginEmail) && !p.getPassword().equals(loginPassword)){
                loginStatus = "Email Address is correct, click 'can't remmber login details' to find Password";
            } else if(!p.getEmailAddress().equals(loginEmail) && p.getPassword().equals(loginPassword)){
                loginStatus = "Password is correct, click 'can't remmber login details' to find your Email Address";
            } else{
                loginStatus = "Email Address and Password are incorrect, click 'can't remmber login details' to discover the correct credentials";
            }
        }
    }
}
