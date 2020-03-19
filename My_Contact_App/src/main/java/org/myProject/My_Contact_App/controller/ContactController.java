package org.myProject.My_Contact_App.controller;

import javax.servlet.http.HttpSession;

import org.myProject.My_Contact_App.entity.Contact;
import org.myProject.My_Contact_App.service.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	
	@Autowired
	private ContactServiceInterface contactInterface;
	
	@RequestMapping(value="/user/contact_form")
	public String contactFform(Model model, HttpSession session) {
		Contact contact= new Contact();
		System.out.println(contact.getContactID());
		session.setAttribute("editContactId", null);
		model.addAttribute("command", contact);
		return "contact_form"; //JSP form view
	}
	
	@RequestMapping(value="/user/save_contact")
	public String saveOrUptadeContactFform(@ModelAttribute("command") Contact con, Model model, HttpSession session) {
		Integer conId= (Integer)session.getAttribute("editContactId");
		System.out.println(conId);
		if(conId==null) {
			//Save action
			try {
				Integer uId= (Integer)session.getAttribute("userId");
				//System.out.println(uId);
				con.setUserID(uId);
				contactInterface.saveContact(con);
				return "redirect:contact_list?action=saveContact"; 
			}
			catch(Exception ex) {
				ex.printStackTrace();
				model.addAttribute("err_message", "Failed to save contact");
				return "contact_form";
			}
		}
		else {
			//update task
			try {
				con.setContactID(conId);
				contactInterface.updateContact(con);
				return "redirect:contact_list?action=edit_contact";
			}
			catch(Exception ex){
				ex.printStackTrace();
				model.addAttribute("err_message", "Failed to edit contact");
				return "contact_form";
			}
		}
	}
	
	@RequestMapping(value="/user/contact_list")
	public String contactList(Model model, HttpSession session) {
		Integer uId= (Integer)session.getAttribute("userId");
		model.addAttribute("contactList", contactInterface.findUserContact(uId));
		return "contact_list"; //JSP form view
	}
	
	@RequestMapping(value="/user/contact_search")
	public String searchContact(Model model, HttpSession session, @RequestParam("freeText") String text) {
		Integer uId= (Integer)session.getAttribute("userId");		
		model.addAttribute("contactList", contactInterface.findUserContact(uId, text));
		return "contact_list"; //JSP form view
	}
	
	@RequestMapping(value="/user/del_contact")
	public String deleteContact(@RequestParam("conId") Integer cid) {
		contactInterface.deleteContact(cid);
		return "redirect:contact_list?action=delete_contact"; //JSP form view
	}
	
	@RequestMapping(value="/user/bulk_delete")
	public String deleteBulkContact(@RequestParam("delCheck") Integer[] contacts) {
		contactInterface.deleteContacts(contacts);
		return "redirect:contact_list?action=delete_contact"; //JSP form view
	}
	
	@RequestMapping(value="/user/edit_contact")
	public String editContactForm(@RequestParam("editContId") Integer coid, Model model, HttpSession session) {
		session.setAttribute("editContactId", coid);
		Contact contact= contactInterface.findByID(coid);
		model.addAttribute("command", contact);
		return "contact_form"; //JSP form view
	}
}
