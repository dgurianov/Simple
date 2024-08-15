import { useSetRecoilState } from 'recoil';
import './App.css';
import ListOfCommits from './list-commits/ListOfCommits';
import NewCommitSection from './new-commit/NewCommitSection';
import SearchCommit from './search-commit/SearchCommit';
import { useEffect } from 'react';
import comm from '../components/Stub.json';
import { tagsStateBucket } from '../state/cjournalState';
import ListOfTags from './list-tags/ListOfTags';

function App() {


const setTagsBasket = useSetRecoilState(tagsStateBucket);
useEffect(()=>{fetchData();});

const fetchData = () => {
  const setOfTags = new Set();
  comm.commits.map((commit)=>{
      return commit.memoTags.map((elTag)=> {return setOfTags.add(elTag)});

  });

  setTagsBasket([...setOfTags.values()]);


}


  return (
    <div className='app-container'>
      <div className='app-logo'>logo</div>
      <div className='app-break'></div>
      <SearchCommit/>
      <ListOfTags/>
      <NewCommitSection/>
      
      <div className='app-list'><ListOfCommits/></div>
    
    </div>
  );
}

export default App;
