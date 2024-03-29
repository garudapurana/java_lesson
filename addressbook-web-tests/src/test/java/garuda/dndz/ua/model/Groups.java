package garuda.dndz.ua.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {
  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  private Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<>();
  }

  public Groups(Collection<GroupData> groups) { this.delegate = new HashSet<GroupData>(groups); }

  public Groups withAdded(GroupData group){
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }
  public Groups without(GroupData group){
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }

}
