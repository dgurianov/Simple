//Modal
//https://www.youtube.com/watch?v=i8YLBufmWV4

import { useRecoilState } from "recoil";
import { commitStateBucket, tagsStateBucket } from "../../state/cjournalState";
import { useState } from "react";
import AxiosClient from "../backend-client/AxiosClient";

const EditCommit = ({originalCommit,setShowEdit}) => {


    const [commitsBucket, setCommitsBucket] = useRecoilState(commitStateBucket);
    const [tagsBasket,setTagsBasket] = useRecoilState(tagsStateBucket);
    const [newCommit , setNewCommit] = useState({
            "commitId": originalCommit.commitId,
            "userName": originalCommit.userName,
            "repoId": originalCommit.repoId,
            "tags": originalCommit.tags,
            "description": originalCommit.description
    });
    const [hasChanged, setHasChanged] = useState(false);


    const handleSubmit = (event) => {
        console.log(newCommit);
        console.log("")
        //event.preventDefault();
        if(hasChanged){

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
                const survivals = commitsBucket.filter((commit)=>commit.commitId !==  newCommit.commitId); 
                setCommitsBucket([...survivals,newCommit]);
            }catch (error){
                console.log(error);
            }
    
            // 
            // console.log(newCommit);
        }
        pushCommitToBackend();
    }
        setShowEdit(0);
    


    }

    const handleChange = (event) => {
        switch(event.target.name){
            case "commitId":
                newCommit.commitId = event.target.value;
                console.log("commitId");
                setHasChanged(true);
                break;
            case "userName":
                newCommit.userName = event.target.value;
                console.log("userNAme");
                setHasChanged(true);
                break;
            case "repoId":
                newCommit.repoId = event.target.value;
                console.log("repoId");
                setHasChanged(true);
                break;
            case "descr":
                newCommit.description = event.target.value;
                console.log("descr");
                setHasChanged(true);
                break;
            case "tags":
                newCommit.tags = event.target.value.split(" ").map((tagWord)=> {return {"id":tagWord}});
                console.log("tags");
                setHasChanged(true);
                break;
            default:
                console.log("Not actionable switch value.");
                break;
        }

        setNewCommit({...newCommit});
       

    }

     return(
          <div  className='app-new'>
            <label className="app-new-line-name">Commit id</label><input value={newCommit.commitId} name="commitId"  type="text" className="app-new-line-input"/>
            <label className="app-new-line-name">Username</label><input value={newCommit.userName} name="userName" onChange={handleChange} type="text" className="app-new-line-input"/>
            <label className="app-new-line-name">Repository id</label><input  value={newCommit.repoId} name="repoId" onChange={handleChange} type="text" className="app-new-line-input"/>
           
            <label className="app-new-line-name">Description</label><input value={newCommit.description} name="descr" onChange={handleChange} type="text" className="app-new-line-input"/>
            <button className="app-new-line-button" onClick={handleSubmit} type="submit" >Save edit</button>
        </div>
     );

}

// <label className="app-new-line-name">Key words</label><input value={newCommit.tags} name="tags" onChange={handleChange} type="text" className="app-new-line-input"/>


export default EditCommit;