export class OddEvenEvent{
    id: number;
    type: OddEvenEnum;
}

export enum OddEvenEnum{
    ODD = 'Odd',
    EVEN = 'Even'
}