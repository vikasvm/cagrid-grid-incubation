/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-core/LICENSE.txt for details.
*============================================================================
**/
package org.cagrid.i2b2.domain;

import java.util.Date;


public class MapData extends I2B2Type {

    private Double numericValue = null;
    private String textValue = null;
    private String valueFlag = null;
    private Double quantity = null;
    private String units = null;
    private Date endDate = null;
    private String location = null;
    private Double confidence = null;
    
    private Visit visit = null;
    private Patient patient = null;
    private Concept concept = null;
    private Map map = null;


    public MapData() {
        super();
    }


    public Double getNumericValue() {
        return numericValue;
    }


    public void setNumericValue(Double numericValue) {
        this.numericValue = numericValue;
    }


    public String getTextValue() {
        return textValue;
    }


    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }


    public String getValueFlag() {
        return valueFlag;
    }


    public void setValueFlag(String valueFlag) {
        this.valueFlag = valueFlag;
    }


    public Double getQuantity() {
        return quantity;
    }


    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }


    public String getUnits() {
        return units;
    }


    public void setUnits(String units) {
        this.units = units;
    }


    public Date getEndDate() {
        return endDate;
    }


    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public Double getConfidence() {
        return confidence;
    }


    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
    
    
    public Visit getVisit() {
        return visit;
    }
    
    
    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    
    
    public Patient getPatient() {
        return patient;
    }
    
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    public Concept getConcept() {
        return concept;
    }
    
    
    public void setConcept(Concept concept) {
        this.concept = concept;
    }
    
    
    public Map getMap() {
        return map;
    }
    
    
    public void setMap(Map map) {
        this.map = map;
    }


    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((concept == null) ? 0 : concept.hashCode());
        result = prime * result + ((confidence == null) ? 0 : confidence.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((map == null) ? 0 : map.hashCode());
        result = prime * result + ((numericValue == null) ? 0 : numericValue.hashCode());
        result = prime * result + ((patient == null) ? 0 : patient.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((textValue == null) ? 0 : textValue.hashCode());
        result = prime * result + ((units == null) ? 0 : units.hashCode());
        result = prime * result + ((valueFlag == null) ? 0 : valueFlag.hashCode());
        result = prime * result + ((visit == null) ? 0 : visit.hashCode());
        return result;
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MapData other = (MapData) obj;
        if (concept == null) {
            if (other.concept != null) {
                return false;
            }
        } else if (!concept.equals(other.concept)) {
            return false;
        }
        if (confidence == null) {
            if (other.confidence != null) {
                return false;
            }
        } else if (!confidence.equals(other.confidence)) {
            return false;
        }
        if (endDate == null) {
            if (other.endDate != null) {
                return false;
            }
        } else if (!endDate.equals(other.endDate)) {
            return false;
        }
        if (location == null) {
            if (other.location != null) {
                return false;
            }
        } else if (!location.equals(other.location)) {
            return false;
        }
        if (map == null) {
            if (other.map != null) {
                return false;
            }
        } else if (!map.equals(other.map)) {
            return false;
        }
        if (numericValue == null) {
            if (other.numericValue != null) {
                return false;
            }
        } else if (!numericValue.equals(other.numericValue)) {
            return false;
        }
        if (patient == null) {
            if (other.patient != null) {
                return false;
            }
        } else if (!patient.equals(other.patient)) {
            return false;
        }
        if (quantity == null) {
            if (other.quantity != null) {
                return false;
            }
        } else if (!quantity.equals(other.quantity)) {
            return false;
        }
        if (textValue == null) {
            if (other.textValue != null) {
                return false;
            }
        } else if (!textValue.equals(other.textValue)) {
            return false;
        }
        if (units == null) {
            if (other.units != null) {
                return false;
            }
        } else if (!units.equals(other.units)) {
            return false;
        }
        if (valueFlag == null) {
            if (other.valueFlag != null) {
                return false;
            }
        } else if (!valueFlag.equals(other.valueFlag)) {
            return false;
        }
        if (visit == null) {
            if (other.visit != null) {
                return false;
            }
        } else if (!visit.equals(other.visit)) {
            return false;
        }
        return true;
    }
}
