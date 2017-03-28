/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Sortie;
import bean.SortieItem;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author the joker
 */
@Stateless
public class SortieFacade extends AbstractFacade<Sortie> {

    @PersistenceContext(unitName = "gestionStockInventairePU")
    private EntityManager em;
    
    private SortieItem sortieItem;
    @EJB
    private SortieItemFacade sortieItemFacade;
    
     public void clone(Sortie sortieSource,Sortie sortieDestination){
        sortieDestination.setId(sortieSource.getId());
        sortieDestination.setDateSortie(sortieSource.getDateSortie());
    }
   
    public Sortie clone(Sortie sortie){
        Sortie cloned=new Sortie();
        clone(sortie, cloned);
        return cloned;
    }
    
     public void save(Sortie sortie,List<SortieItem>sortieItems){
       sortie.setId(generateId("Sortie", "id"));
       create(sortie);
       for(SortieItem sortieItem:sortieItems){
           sortieItem.setSortie(sortie);
           sortieItemFacade.create(sortieItem);
       }
       edit(sortie);
   }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SortieFacade() {
        super(Sortie.class);
    }

    public SortieItem getSortieItem() {
        return sortieItem;
    }

    public void setSortieItem(SortieItem sortieItem) {
        this.sortieItem = sortieItem;
    }

    public SortieItemFacade getSortieItemFacade() {
        return sortieItemFacade;
    }

    public void setSortieItemFacade(SortieItemFacade sortieItemFacade) {
        this.sortieItemFacade = sortieItemFacade;
    }
    
}
