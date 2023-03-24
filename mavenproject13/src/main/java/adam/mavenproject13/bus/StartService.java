/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package adam.mavenproject13.bus;

import adam.mavenproject13.ents.Books;
import adam.mavenproject13.ents.Person;
import adam.mavenproject13.ents.bookList;
import adam.mavenproject13.pers.BooksFacade;
import adam.mavenproject13.pers.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author adamt
 */
@Stateless
public class StartService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private PersonFacade pf;

    @EJB
    private BooksFacade bf;

    public void startStarting(String name, String surname, String email, String password) {
        Person p = new Person();
        p.setName(name);
        p.setSurname(surname);
        p.setEmailAddress(email);
        p.setPassword(password);
        //save this in database
        pf.create(p);
    }

    public void addBooks() {
        bookList bl = new bookList();
        for (int i = 0; i < bl.getAuthors().size(); i++) {
            String title = bl.getTitle(i);
            String author = bl.getAuthor(i);
            String publisher = bl.getPublisher(i);
            String edition = bl.getEdition(i);
            String year = bl.getYear(i);
            String price = bl.getOnePrice(i);
            String copy = bl.getCopy(i);
            Books b = new Books();
            b.setTitle(title);
            b.setAuthor(author);
            b.setPublisher(publisher);
            b.setEdition(edition);
            b.setYearOfPublication(year);
            b.setPrice(price);
            b.setCopies(copy);
            bf.create(b);
        }
    }

    public List<Books> findBooks(String title) {
        Books b = new Books();
        String title2 = b.getTitle();
        List<Books> bs = retrieveBooks();
        List<Books> books;
        books = new ArrayList<>();
        for (int i = 0; i < bs.size(); i++) {
            b = bs.get(i);
            if (title2.equals(title)) {
                books.add(b);
            }
        }
        return books;
    }

    public String findPassword(String emailAddress) {
//        Person p = new Person();
        List<Person> users = pf.findAll();
        String passwordFound = "";
        for (int i = 0; i < users.size(); i++) {
            Person per = users.get(i);
            
            if (per.getEmailAddress().equals(emailAddress)) {
                passwordFound = per.getPassword();
            }
        }
        return passwordFound;
    }
    
    public String findEmailAddress(String forename, String surname){
        List<Person> users = pf.findAll();
        String emailAddressFound = "";
        for(int i = 0; i < users.size(); i++){
            Person per = users.get(i);
            
            if(per.getName().equals(forename) && per.getSurname().equals(surname)){
                emailAddressFound = per.getEmailAddress();
            }
        }
        return emailAddressFound;
    }

    public List<Books> retrieveBooks() {
        List<Books> b = bf.findAll();
        return b;
    }
}
