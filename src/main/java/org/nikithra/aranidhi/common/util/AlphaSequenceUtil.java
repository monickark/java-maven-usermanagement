/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.common.util;

import org.springframework.stereotype.Component;

//Start of user code (user defined imports)

//End of user code


/**
* Description of AranidhiApplication.
* 
* @author NIKITHRA
*/
@Component
public class AlphaSequenceUtil {
	
	/**
	 * Description of the method generateAlphaSequence.
	 * @param sequence 
	 */
	public static String generateAlphaSequence(String seqString,Integer seq){
		 // Start of user code for method generateAlphaSequence
		String sequence = null;
		
		if((seq>=0)&&(seq<=9)){
			sequence  = seqString.concat("000").concat(seq.toString());
		}else if((seq>=10)&&(seq<=99)){
			sequence  = seqString.concat("00").concat(seq.toString());
		}else if((seq>=100)&&(seq<=999)){
			sequence  = seqString.concat("0").concat(seq.toString());
		}
		else{
			sequence  = seqString.concat(seq.toString());
		}
		
		return sequence;
		// End of user code

	}

}
