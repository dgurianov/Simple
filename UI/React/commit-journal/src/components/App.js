import { useSetRecoilState } from 'recoil';
import './App.css';
import ListOfCommits from './list-commits/ListOfCommits';
import NewCommitSection from './new-commit/NewCommitSection';
import SearchCommit from './search-commit/SearchCommit';
import { useEffect, useState } from 'react';
import { commitStateBucket, tagsStateBucket } from '../state/cjournalState';
import ListOfTags from './list-tags/ListOfTags';
import NavigationStripe from './nav/NavigationStripe';
import AxiosClient from './backend-client/AxiosClient';

function App() {

const setCommitsBucket = useSetRecoilState(commitStateBucket);
const setTagsBasket = useSetRecoilState(tagsStateBucket);
const [fetchState, setFetchState] = useState({
  isLoading: false,
  error: null,
});


useEffect(()=>{fetchData()},[]);

const fetchData = () => {

  /*comm.commits.map((commit)=>{
      return commit.memoTags.map((elTag)=> {return setOfTags.add(elTag)});

  });*/

  const loadCommitsFromBackend = async () => {
    try{
      const {data} = await AxiosClient.get('/api/v1/commit/');
      setCommitsBucket([...data]);
      const tagArraysFromAllCommits = data.map((commit)=>{return [...commit.tags]});
      const tagsToSaveToState = new Set();
      tagArraysFromAllCommits.forEach(
            (arrayOfTags)=>{
              arrayOfTags.forEach(
                (tagInCurrentArray)=>{
                              tagsToSaveToState.add(tagInCurrentArray.id)
                            }
                          )
                        }
                      );
      setTagsBasket([...tagsToSaveToState]);
      setFetchState({
        isLoading: false,
          });
          
    // console.log(data);
    
    }catch(error){
          setFetchState({
            error,
            isLoading : false
        });
        console.log(error);
    }
  }

  loadCommitsFromBackend();
}
 
  return (
    <div className='app-container'>
      <div className='app-logo'>logo</div>
      <div className='app-break'></div>
      <NavigationStripe/>
      <ListOfTags/>
      {window.location.pathname === "/search" ? <SearchCommit/> :<NewCommitSection/>}
      <ListOfCommits/>
    </div>
  );
}

export default App;
