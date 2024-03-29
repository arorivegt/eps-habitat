package org.habitatguate.hgerp.seguridad.client.finanzas;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.place.shared.Prefix;
import com.google.gwt.user.client.ui.SuggestOracle;



public class BeneNameSuggestOracle extends SuggestOracle {

	private List<BeneMultiWordSuggestion> materialSuggestions = null;
	
	@Override
	public void requestSuggestions(Request request, Callback callback) {
		// TODO Auto-generated method stub
        Response resp = new Response( matchingPeople( request.getQuery(),
                request.getLimit() ) );

        callback.onSuggestionsReady(request, resp);
	}

	/**
     * 
     * @param query The current text being entered into the suggest box
     * @param limit The maximum number of results to return 
     * @return A collection of people suggestions that match.
     */
     public Collection<BeneMultiWordSuggestion> matchingPeople(String query, int limit)
     {
         List<BeneMultiWordSuggestion> matchingPeople = new ArrayList<BeneMultiWordSuggestion>(limit);
 
         // only begin to search after the user has type two characters
         if ( query.length() >= 2 )
         {
             String prefixToMatch = query.toLowerCase();
 
             int i = 0;
             int s = materialSuggestions.size();
 
             // Skip forward over all the names that don't match at the beginning of the array.
             while (i < s && !materialSuggestions.get(i).getDisplayString().toLowerCase().startsWith(prefixToMatch) )
             {
                 i++;
             }
 
             // Now we are at the start of the block of matching names. Add matching names till we
             // run out of names, stop finding matches, or have enough matches.
             int count = 0;
 
             while (i < s && materialSuggestions.get(i).getDisplayString().toLowerCase().startsWith(prefixToMatch) && count < limit) 
             {
                 matchingPeople.add( materialSuggestions.get(i) );
                 i++;
                 count++;
             }
 
         }
         else
         {
             String prefixToMatch = query.toUpperCase();
        	 int i = 0;
        	 int s = materialSuggestions.size();
             while (i < s)
             {
            	 if (materialSuggestions.get(i).getDisplayString().startsWith(prefixToMatch))
            			 matchingPeople.add( materialSuggestions.get(i) );
                 i++;
             }
         }
 //		System.out.println("Numero de encontrados "+ matchingPeople.size() + " "+ materialSuggestions.size());
             return matchingPeople;
     }
 
 
 
        /**
         * @param o 
         * @return
         * @see java.util.List#add(java.lang.Object)
         */
         public boolean add(BeneMultiWordSuggestion o)
         {
             if ( materialSuggestions == null )
             {
                materialSuggestions = new ArrayList<BeneMultiWordSuggestion>();
             }
 
             return materialSuggestions.add(o);
         }
 
 
 
        /**
         * @param o
         * @return
         * @see java.util.List#remove(java.lang.Object)
         */
         public boolean remove(Object o)
         {
             if ( materialSuggestions != null)
             {
                 return materialSuggestions.remove(o);
             }
 
             return false;
          }
	
}
