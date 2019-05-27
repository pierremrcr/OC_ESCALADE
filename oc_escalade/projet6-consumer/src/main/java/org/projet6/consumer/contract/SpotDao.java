package org.projet6.consumer.contract;

import java.util.List;

import org.projet6.model.bean.Spot;

public interface SpotDao {

	public List<Spot> listspot();
	
	public Spot getbyID(int id);

    public  Spot create(Spot spot);

    public void supprimeSpot(int id);
    
    public void updateSpot(Spot spot);
    
    public List<Spot> getSpotByRegion(String region);
    
   public List<Spot> rechercheMultiCriteres(String region, int nombreDePoints, String typeCotation);
    
    //public List<Spot> rechercheMultiCriteres(int nombreDePoints, String typeCotation);

}