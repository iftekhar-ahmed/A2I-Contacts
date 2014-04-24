package com.example.a2icontacts.dao;

import com.example.a2icontacts.model.raw.A2IContact;
import com.example.a2icontacts.model.raw.A2ITeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukla on 4/24/14.
 */
public final class ContactsAccessor {
    static List<A2IContact> a2iContacts = new ArrayList<A2IContact>();
    static List<A2ITeam>a2ITeams=new ArrayList<A2ITeam>();

    static {
        a2iContacts.add(new A2IContact("+8801911320311","Anir Chowdhury","anirchowdhury@pmo.gov.bd"));
        a2iContacts.add(new A2IContact("+8801921694123","Md. Mazedul Islam","islam.mazedul@gmail.com"));
        a2iContacts.add(new A2IContact("+8801713244359","Hasanuzzaman","zaman.h1984@gmail.com"));
        a2iContacts.add(new A2IContact("+8801715578194","Sohana Samrin Chowdhury","sohanasamrin@a2i.pmo.gov.bd"));
        a2iContacts.add(new A2IContact("+8801729298989","Asad Ur Rahman Nile","asadrahman@a2i.pmo.gov.bd"));
        a2iContacts.add(new A2IContact("+8801913760134","Sami Ahmed","sami.ahmed@a2i.pmo.gov.bd"));
        a2iContacts.add(new A2IContact("+8801741039412","Rezwanul Islam","rezwan@gmail.com"));
        a2iContacts.add(new A2IContact("+8801712236211","Mohammed Naser Miah","naser@pmo.gov.bd"));
        a2iContacts.add(new A2IContact("+8801716422362","Md. Habibullah","mdhabibullah97@yahoo.com"));
        a2iContacts.add(new A2IContact("+8801726297993","Mahfuza Haque","mahfuzahaque@a2i.pmo.gov.bd"));
        a2iContacts.add(new A2IContact("+8801819804689","Md. Ullah Rabbi","ullah.rabbi@undp.org"));
        a2iContacts.add(new A2IContact("+8801711074083","Shohel Aman Chowdhhury","shohelaman@gmail.com"));

        a2ITeams.add(new A2ITeam("Policy"));
        a2ITeams.add(new A2ITeam("Innovation"));
        a2ITeams.add(new A2ITeam("Operation"));
        a2ITeams.add(new A2ITeam("Capacity Development"));
        a2ITeams.add(new A2ITeam("Communication & Partnership"));
        a2ITeams.add(new A2ITeam("E-Service Implementation"));
        a2ITeams.add(new A2ITeam("Ness Development"));
        a2ITeams.add(new A2ITeam("E-Office"));


    }

    public static List<A2ITeam> getA2ITeams() {
        return a2ITeams;
    }

    public static List<A2IContact> geta2iContacts() {
        return a2iContacts;
    }
}
