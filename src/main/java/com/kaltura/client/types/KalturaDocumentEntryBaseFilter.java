package com.kaltura.client.types;

import java.util.IllegalFormatException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.kaltura.client.KalturaObjectBase;
import com.kaltura.client.KalturaParams;
import com.kaltura.client.KalturaApiException;
import com.kaltura.client.KalturaObjectFactory;
import com.kaltura.client.enums.KalturaDocumentType;


/**
 * This class was generated using generate.php
 * against an XML schema provided by Kaltura.
 * @date Sun, 19 Jun 11 02:46:50 -0400
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

public abstract class KalturaDocumentEntryBaseFilter extends KalturaBaseEntryFilter {
    public KalturaDocumentType documentTypeEqual;
    public String documentTypeIn;

    public KalturaDocumentEntryBaseFilter() {
    }

    public KalturaDocumentEntryBaseFilter(Element node) throws KalturaApiException {
        super(node);
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node aNode = childNodes.item(i);
            String txt = aNode.getTextContent();
            String nodeName = aNode.getNodeName();
            if (false) {
                // noop
            } else if (nodeName.equals("documentTypeEqual")) {
                try {
                    if (!txt.equals("")) this.documentTypeEqual = KalturaDocumentType.get(Integer.parseInt(txt));
                } catch (NumberFormatException nfe) {}
                continue;
            } else if (nodeName.equals("documentTypeIn")) {
                this.documentTypeIn = txt;
                continue;
            } 

        }
    }

    public KalturaParams toParams() {
        KalturaParams kparams = super.toParams();
        kparams.setString("objectType", "KalturaDocumentEntryBaseFilter");
        if (documentTypeEqual != null) kparams.addIntIfNotNull("documentTypeEqual", this.documentTypeEqual.getHashCode());
        kparams.addStringIfNotNull("documentTypeIn", this.documentTypeIn);
        return kparams;
    }
}

