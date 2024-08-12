import { atom } from "recoil";

const commitStateBucket = atom({
    key:"commit-basket",
    default:[]
});

export {commitStateBucket};