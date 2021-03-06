/**
 * MAN Trucks
 * Esta é a definição da API para o code challenge
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *//* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent }                           from '@angular/common/http';
import { CustomHttpUrlEncodingCodec }                        from '../encoder';

import { Observable }                                        from 'rxjs';

import { Truck } from '../model/truck';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class TruckService {

    protected basePath = 'https://localhost:8080/v1';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
            this.basePath = basePath || configuration.basePath || this.basePath;
        }
    }

    /**
     * @param consumes string[] mime-types
     * @return true: consumes contains 'multipart/form-data', false: otherwise
     */
    private canConsumeForm(consumes: string[]): boolean {
        const form = 'multipart/form-data';
        for (const consume of consumes) {
            if (form === consume) {
                return true;
            }
        }
        return false;
    }


    /**
     * Adds a new truck
     * 
     * @param body Truck object
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public addTruck(body: Truck, observe?: 'body', reportProgress?: boolean): Observable<any>;
    public addTruck(body: Truck, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<any>>;
    public addTruck(body: Truck, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<any>>;
    public addTruck(body: Truck, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling addTruck.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json',
            'application/xml'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.request<any>('post',`${this.basePath}/trucks`,
            {
                body: body,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Deletes a truck
     * 
     * @param truckId Truck id to delete
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public deleteTruck(truckId: number, observe?: 'body', reportProgress?: boolean): Observable<any>;
    public deleteTruck(truckId: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<any>>;
    public deleteTruck(truckId: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<any>>;
    public deleteTruck(truckId: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (truckId === null || truckId === undefined) {
            throw new Error('Required parameter truckId was null or undefined when calling deleteTruck.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];

        return this.httpClient.request<any>('delete',`${this.basePath}/trucks/${encodeURIComponent(String(truckId))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Find truck by ID
     * Returns a single truck
     * @param truckId ID of truck to return
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public getTruckById(truckId: number, observe?: 'body', reportProgress?: boolean): Observable<Truck>;
    public getTruckById(truckId: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<Truck>>;
    public getTruckById(truckId: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<Truck>>;
    public getTruckById(truckId: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (truckId === null || truckId === undefined) {
            throw new Error('Required parameter truckId was null or undefined when calling getTruckById.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/xml',
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];

        return this.httpClient.request<Truck>('get',`${this.basePath}/trucks/${encodeURIComponent(String(truckId))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * List all trucks
     * 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public listTruck(observe?: 'body', reportProgress?: boolean): Observable<Array<Truck>>;
    public listTruck(observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<Array<Truck>>>;
    public listTruck(observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<Array<Truck>>>;
    public listTruck(observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/xml',
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];

        return this.httpClient.request<Array<Truck>>('get',`${this.basePath}/trucks`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

     /**
     * Update an existing truck
     * 
     * @param body Truck object that needs to be updated
     * @param truckId ID of truck to return
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public updateTruck(body: Truck, truckId: number, observe?: 'body', reportProgress?: boolean): Observable<any>;
    public updateTruck(body: Truck, truckId: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<any>>;
    public updateTruck(body: Truck, truckId: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<any>>;
    public updateTruck(body: Truck, truckId: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling updateTruck.');
        }

        if (truckId === null || truckId === undefined) {
            throw new Error('Required parameter truckId was null or undefined when calling updateTruck.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json',
            'application/xml'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.request<any>('put',`${this.basePath}/trucks/${encodeURIComponent(String(truckId))}`,
            {
                body: body,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Updates a truck with form data
     * 
     * @param id 
     * @param name 
     * @param engineHP 
     * @param engineVolume 
     * @param fuel 
     * @param segments 
     * @param colors 
     * @param truckId ID of truck that needs to be updated
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public updateTruckWithForm(id: number, name: string, engineHP: number, engineVolume: number, fuel: string, segments: Array<string>, colors: Array<string>, truckId: number, observe?: 'body', reportProgress?: boolean): Observable<any>;
    public updateTruckWithForm(id: number, name: string, engineHP: number, engineVolume: number, fuel: string, segments: Array<string>, colors: Array<string>, truckId: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<any>>;
    public updateTruckWithForm(id: number, name: string, engineHP: number, engineVolume: number, fuel: string, segments: Array<string>, colors: Array<string>, truckId: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<any>>;
    public updateTruckWithForm(id: number, name: string, engineHP: number, engineVolume: number, fuel: string, segments: Array<string>, colors: Array<string>, truckId: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling updateTruckWithForm.');
        }

        if (name === null || name === undefined) {
            throw new Error('Required parameter name was null or undefined when calling updateTruckWithForm.');
        }

        if (engineHP === null || engineHP === undefined) {
            throw new Error('Required parameter engineHP was null or undefined when calling updateTruckWithForm.');
        }

        if (engineVolume === null || engineVolume === undefined) {
            throw new Error('Required parameter engineVolume was null or undefined when calling updateTruckWithForm.');
        }

        if (fuel === null || fuel === undefined) {
            throw new Error('Required parameter fuel was null or undefined when calling updateTruckWithForm.');
        }

        if (segments === null || segments === undefined) {
            throw new Error('Required parameter segments was null or undefined when calling updateTruckWithForm.');
        }

        if (colors === null || colors === undefined) {
            throw new Error('Required parameter colors was null or undefined when calling updateTruckWithForm.');
        }

        if (truckId === null || truckId === undefined) {
            throw new Error('Required parameter truckId was null or undefined when calling updateTruckWithForm.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/x-www-form-urlencoded'
        ];

        const canConsumeForm = this.canConsumeForm(consumes);

        let formParams: { append(param: string, value: any): void; };
        let useForm = false;
        let convertFormParamsToString = false;
        if (useForm) {
            formParams = new FormData();
        } else {
            formParams = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
        }

        if (id !== undefined) {
            formParams = formParams.append('id', <any>id) as any || formParams;
        }
        if (name !== undefined) {
            formParams = formParams.append('name', <any>name) as any || formParams;
        }
        if (engineHP !== undefined) {
            formParams = formParams.append('engineHP', <any>engineHP) as any || formParams;
        }
        if (engineVolume !== undefined) {
            formParams = formParams.append('engineVolume', <any>engineVolume) as any || formParams;
        }
        if (fuel !== undefined) {
            formParams = formParams.append('fuel', <any>fuel) as any || formParams;
        }
        if (segments) {
            segments.forEach((element) => {
                formParams = formParams.append('segments', <any>element) as any || formParams;
            })
        }
        if (colors) {
            colors.forEach((element) => {
                formParams = formParams.append('colors', <any>element) as any || formParams;
            })
        }

        return this.httpClient.request<any>('post',`${this.basePath}/trucks/${encodeURIComponent(String(truckId))}`,
            {
                body: convertFormParamsToString ? formParams.toString() : formParams,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
