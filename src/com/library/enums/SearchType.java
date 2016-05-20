
package com.library.enums;

public enum SearchType {

    FUZZY("Fuzzy"), PRECISE("Precise");
    String searchType;

    private SearchType(String searchType)
    {
        this.searchType = searchType;
    }

    public String getSearchType()
    {
        return this.searchType;
    }

    public String toString()
    {
        return this.searchType;
    }

    public Boolean equals(String obj)
    {
        if (this.searchType.equals(obj))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
