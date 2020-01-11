/**
 * MAN Trucks
 * This is a sample server Truckstore server.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

export interface Truck { 
    id?: number;
    name: string;
    engineHP: string;
    engineVolume: string;
    fuel?: string;
    /**
     * truck segment
     */
    segment: Truck.SegmentEnum;
    colors: Array<string>;
}
export namespace Truck {
    export type SegmentEnum = 'Long Haul' | 'Construction' | 'Firedepartment' | 'Distribution (Food)' | 'Wastedisposal';
    export const SegmentEnum = {
        LongHaul: 'Long Haul' as SegmentEnum,
        Construction: 'Construction' as SegmentEnum,
        Firedepartment: 'Firedepartment' as SegmentEnum,
        DistributionFood: 'Distribution (Food)' as SegmentEnum,
        Wastedisposal: 'Wastedisposal' as SegmentEnum
    };
}