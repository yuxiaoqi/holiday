package com.yyq.holiday.common.resultbo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Dscription: 国家bo对象
 * @Created: yyq
 * @Date: 2017/1/22 15:24
 * @version: 1.0.0.0
 */
@Data
public class CountryBO implements Serializable {
    /**
     * <pre>
     *
     *  country.Code
     *
     */
    private String code;

    /**
     * <pre>
     *
     * country.Name
     * </pre>
     *
     */
    private String name;

    /**
     * <pre>
     *
     * country.Continent
     * </pre>
     *
     */
    private String continent;

    /**
     * <pre>
     *
     * country.Region
     * </pre>
     *
     */
    private String region;

    /**
     * <pre>
     *
     * country.SurfaceArea
     * </pre>
     *
     */
    private Float surfacearea;

    /**
     * <pre>
     *
     * country.IndepYear
     * </pre>
     *
     */
    private Short indepyear;

    /**
     * <pre>
     *
     * country.Population
     * </pre>
     *
     */
    private Integer population;

    /**
     * <pre>
     *
     * country.LifeExpectancy
     * </pre>
     *
     */
    private Float lifeexpectancy;

    /**
     * <pre>
     *
     *  country.GNP
     * </pre>
     *
     */
    private Float gnp;

    /**
     * <pre>
     *
     * country.GNPOld
     * </pre>
     *
     */
    private Float gnpold;

    /**
     * <pre>
     *
     * country.LocalName
     * </pre>
     *
     */
    private String localname;

    /**
     * <pre>
     *
     *  country.GovernmentForm
     * </pre>
     *
     */
    private String governmentform;

    /**
     * <pre>
     *
     *  country.HeadOfState
     * </pre>
     *
     */
    private String headofstate;

    /**
     * <pre>
     *
     * country.Capital
     * </pre>
     *
     */
    private Integer capital;

    /**
     * <pre>
     *
     *  country.Code2
     * </pre>
     *
     */
    private String code2;
}
