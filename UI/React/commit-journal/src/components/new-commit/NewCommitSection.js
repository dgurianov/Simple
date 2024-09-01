import { useState } from 'react';
import './NewCommitSection.css';
import AxiosClient from '../backend-client/AxiosClient';
import { useRecoilState, useSetRecoilState } from 'recoil';
import { commitStateBucket, tagsStateBucket } from '../../state/cjournalState';

const NewCommitSection = () => {
    const [commitsBucket, setCommitsBucket] = useRecoilState(commitStateBucket);
    const [tagsBasket,setTagsBasket] = useRecoilState(tagsStateBucket);
    const [newCommit , setNewCommit] = useState({
            "commitId": null,
            "userName": null,
            "repoId": null,
            "tags": [],
            "description": null
    });


    const handleSubmit = (event) => {
        console.log(newCommit);
        console.log("")
        //event.preventDefault();

        const pushCommitToBackend = async () => {
            try{
                const {data} = await AxiosClient.put('/api/v1/commit/',JSON.stringify([newCommit]),{headers: {
                    "Content-Type": "application/json"}});
                console.log(data);
                const newTags = new Set(tagsBasket);
                data[0].tags.forEach(newTag => {
                    newTags.add(newTag.id);
                });
                setTagsBasket([...newTags]);
                setCommitsBucket([...commitsBucket,newCommit]);
            }catch (error){
                console.log(error);
            }
    
            // 
            // console.log(newCommit);
        }
        pushCommitToBackend();


    }

    const handleChange = (event) => {
        switch(event.target.name){
            case "commitId":
                newCommit.commitId = event.target.value;
                console.log("commitId");
                break;
            case "userName":
                newCommit.userName = event.target.value;
                console.log("userNAme");
                break;
            case "repoId":
                newCommit.repoId = event.target.value;
                console.log("repoId");
                break;
            case "descr":
                newCommit.description = event.target.value;
                console.log("descr");
                break;
            case "tags":
                newCommit.tags = event.target.value.split(" ").map((tagWord)=> {return {"id":tagWord}});
                console.log("tags");
                break;
            default:
                console.log("Not actionable switch value.");
                break;
        }
       

    }

    return(
        <form  className='app-new'>
            <label className="app-new-line-name">Commit id</label><input  name="commitId" onChange={handleChange} type="text" className="app-new-line-input"/>
            <label className="app-new-line-name">Username</label><input name="userName" onChange={handleChange} type="text" className="app-new-line-input"/>
            <label className="app-new-line-name">Repository id</label><input name="repoId" onChange={handleChange} type="text" className="app-new-line-input"/>
            <label className="app-new-line-name">Key words</label><input name="tags" onChange={handleChange} type="text" className="app-new-line-input"/>
            <label className="app-new-line-name">Description</label><input name="descr" onChange={handleChange} type="text" className="app-new-line-input"/>
            <button className="app-new-line-button" onClick={handleSubmit} type="submit" >Add new</button>
        </form>
   );
}


export default NewCommitSection;