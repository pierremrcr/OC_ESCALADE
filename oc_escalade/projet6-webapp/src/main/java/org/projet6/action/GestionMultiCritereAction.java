package org.projet6.action;

import java.util.List;

import org.projet6.model.bean.Spot;

import com.opensymphony.xwork2.ActionSupport;

public class GestionMultiCritereAction extends ActionSupport {
	
	
	private int selectNombreDePoints;
	private String selectCotation;
	private String selectRegion;
	
	private List<Spot> listeSpot;
	private String nombreDepoints[] = {"4","5","6","7","8"};
	private String listeCotation[] = {"6b","6c","7a","7b","7c","8a","8b"};
	
	
	public int getSelectNombreDePoints() {
		return selectNombreDePoints;
	}
	
	public void setSelectNombreDePoints(int selectNombreDePoints) {
		this.selectNombreDePoints = selectNombreDePoints;
	}
	public String getSelectCotation() {
		return selectCotation;
	}
	public void setSelectCotation(String selectCotation) {
		this.selectCotation = selectCotation;
	}
	public List<Spot> getListeSpot() {
		return listeSpot;
	}
	public void setListeSpot(List<Spot> listeSpot) {
		this.listeSpot = listeSpot;
	}
	public String[] getNombreDepoints() {
		return nombreDepoints;
	}
	public void setNombreDepoints(String[] nombreDepoints) {
		this.nombreDepoints = nombreDepoints;
	}
	public String[] getListeCotation() {
		return listeCotation;
	}
	public void setListeCotation(String[] listeCotation) {
		this.listeCotation = listeCotation;
	}
	

	public String getSelectRegion() {
		return selectRegion;
	}

	public void setSelectRegion(String selectRegion) {
		this.selectRegion = selectRegion;
	}

	public String doSearch() {

		String vResult = ActionSupport.INPUT;

		
		if (this.selectRegion != null || this.selectNombreDePoints != 0 || this.selectCotation != null) {

			listeSpot = WebappHelper.getManagerFactory().getSpotManager().rechercheMultiCriteres(selectRegion,selectNombreDePoints,
					selectCotation);

			vResult = ActionSupport.SUCCESS;
			
		}
		
		if (vResult.equals(ActionSupport.INPUT)) {


			listeSpot = WebappHelper.getManagerFactory().getSpotManager().getListSpot();
		
		}
		
	

		return vResult;
		

	}
	
	

}
