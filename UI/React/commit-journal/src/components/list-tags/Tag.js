import { useRecoilState } from 'recoil';
import { commitsFilterState } from '../../state/cjournalState';
import './Tag.css';

const Tag = ({tagname}) => {
    const [tagFilter, setFilter] = useRecoilState(commitsFilterState);

    function onClickTagFilter(e){
      if(tagFilter.has(e.target.value)){
        setFilter(new Set([...tagFilter].filter(tagElement=>tagElement !== e.target.value)));
      }else{        setFilter(new Set([...tagFilter,e.target.value])); }
      
    }

    function isPressed(t){
      return tagFilter.has(t);
    }

    return(
      <button className={isPressed(tagname)? 'tag-pressed' : 'tag' } onClick={onClickTagFilter} value={tagname}>+{tagname}</button> 
    );

}


export default Tag;