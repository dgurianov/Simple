
import { useSetRecoilState } from 'recoil';
import './SearchCommit.css';
import { commitStateBucket } from '../../state/cjournalState';
import AxiosClient from '../backend-client/AxiosClient';
import { useState } from 'react';



 

const SearchCommit = () => {
    const setCommitsBucket = useSetRecoilState(commitStateBucket);
    const [searchState, setSearchState] = useState("");

    const handleChange = (event) => {
        setSearchState(event.target.value);

    }

    const clickSearch = (event) => {
        console.log("Searching...");
        if(searchState === "") return;

        const searchCommitFromBackend = async () => {
            try{
                const {data} = await AxiosClient.get(`/api/v1/commit?q=${searchState}`,{headers: {"Content-Type": "application/json"}});
                console.log(data);
                setCommitsBucket([...data]);
            }catch (error){
                console.log(error);
            }
    
            // 
            // console.log(newCommit);
        }
        searchCommitFromBackend();
        
    
    
     }

    return(
        <div className="app-search">
            <input className="app-search-input" onChange={handleChange} type="text"  ></input>
            <button className="app-search-button"  onClick={clickSearch}  type="submit"> Search</button>
            <div className="app-search-hr"><hr /></div>
        </div>
    );
    
}


export default SearchCommit;