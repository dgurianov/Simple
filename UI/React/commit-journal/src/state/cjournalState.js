import { atom } from "recoil";

const commitStateBucket = atom({
    key:"commit-bucket",
    default:[]
});

const tagsStateBucket = atom(
    {
        key: "tags-bucket",
        default:[""]
    }
);

export {commitStateBucket, tagsStateBucket};