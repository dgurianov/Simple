import {atom} from 'recoil';

const korbState = atom(
    {
        key: 'some-random-key',
        default:[]
    }
);

export {korbState};