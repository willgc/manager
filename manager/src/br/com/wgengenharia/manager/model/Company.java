package br.com.wgengenharia.manager.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.primefaces.model.DefaultStreamedContent;

@Entity
@Table(name = "TAB_COMPANY")
//@SequenceGenerator(name="seqCompany", sequenceName="SEQ_COMPANY",allocationSize=1)
public class Company {
	
	public Company() {
		this.modules = new ArrayList<Module>();
//		this.branchs = new ArrayList<Branch>();
	}
	
	@Id
	@Column(name="ID_COMPANY")
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCompany")
	private int id_company;
	@Column(name="NAME")
	private String name;
	
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinTable(name="TAB_COMPANY_MODULE",joinColumns={@JoinColumn(name="COMPANY_ID", referencedColumnName="ID_COMPANY")}, inverseJoinColumns={@JoinColumn(name="MODULE_ID", referencedColumnName="ID_MODULE")})
	private List<Module> modules;
//  
//  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//  @JoinTable(name="TAB_COMPANY_BRANCH",joinColumns={@JoinColumn(name="COMPANY_ID", referencedColumnName="ID_COMPANY")}, inverseJoinColumns={@JoinColumn(name="BRANCH_ID", referencedColumnName="ID_BRANCH")})
//	private List<Branch> branchs;
	
	@Lob
	@Column(name="IMAGE", length=10000000)
	private byte[] image;
  
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
//	public List<Branch> getBranchs() {
//		return branchs;
//	}
//	public void setBranchs(List<Branch> branchs) {
//		this.branchs = branchs;
//	}
	
	//metodos
	
//	public void addBranch(Branch branch){
//		this.branchs.add(branch);
//	}
	public void addModule(Module module){
		this.modules.add(module);
	}
	
	
	// retorna imagem para grafichimage
	public DefaultStreamedContent getCompanyImage(){
		if(image != null){
			InputStream is = new ByteArrayInputStream((byte[]) this.image);
			return new DefaultStreamedContent(is, "image/png");
		}else{
			return null;
		}
	}
	
	
	
}
