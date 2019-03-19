package br.com.unitins.agr.agenda.controllers;

import br.com.unitins.agr.agenda.models.Contact;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ContactController implements Serializable {
    private static final long serialVerionID = 1L;

    private List<Contact> contacts = null;
    private Contact contact = new Contact();
    private boolean editing = false;

    @PostConstruct
    public void init() {
        contacts = new ArrayList<Contact>();
    }

    public void add() {
        contact.setId(contacts.isEmpty() ? 1 : contacts.get(contacts.size() - 1).getId() + 1);
        contacts.add(contact);
        contact = new Contact();
    }

    public void edit(Contact contact) {
        this.contact = contact;
        editing = true;
    }

    public void saveEdit() {
        this.contact = new Contact();
        editing = false;
    }

    public void delete(Contact contact) {
        contacts.remove(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact() {
        return contact;
    }

    public boolean isEdit() {
        return editing;
    }
}
