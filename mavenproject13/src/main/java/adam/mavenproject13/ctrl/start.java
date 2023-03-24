/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adam.mavenproject13.ctrl;

import adam.mavenproject13.bus.StartService;
import adam.mavenproject13.ents.Books;
import adam.mavenproject13.ents.bookList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author adamt
 */
@Named(value = "start")
@RequestScoped
public class start {

    /**
     * Creates a new instance of start
     */
    public start() {
    }

    private String name;
    private String surname;
    private String emailAddress;
    private String password;

    private String Title;
    private String Author;

    private String yearOfPublication;
    private String priceRange;

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
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
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
//        List<Books> bookList = ss.retrieveBooks();
        List<Books> books = ss.findBooks(Title);

        for (int i = 0; i < books.size(); i++) {
            listOfBooks.add(books.get(i));
        }
    }

//    @PostConstruct
    public void addBooks() {
        ss.addBooks();

    }
    
    private String newEmailAddress;

    public String getNewEmailAddress() {
        return newEmailAddress;
    }

    public void setNewEmailAddress(String newEmailAddress) {
        this.newEmailAddress = newEmailAddress;
    }
    
    public void findEmailAddress(){
        newEmailAddress = ss.findEmailAddress(name, surname);
    }
    
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    public void findPassword(){
        newPassword = ss.findPassword(emailAddress);
        
    }

}
